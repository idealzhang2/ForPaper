package com.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.*;
import org.apache.lucene.queries.function.*;
import org.apache.lucene.queries.function.valuesource.IntFieldSource;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version; 
import java.io.IOException;
 
/**
 * @author hankcs
 */
public class TestSortByTime
{
    public static void main(String[] args)
    {
        // Lucene Document的主要域名
        String fieldName = "text";
 
        // 实例化IKAnalyzer分词器
        Analyzer analyzer = new StandardAnalyzer();
 
        Directory directory = null;
        IndexWriter iwriter;
        IndexReader ireader = null;
        IndexSearcher isearcher;
        try
        {
            //索引过程**********************************
            //建立内存索引对象
            directory = new RAMDirectory();
 
            //配置IndexWriterConfig
            IndexWriterConfig iwConfig = new IndexWriterConfig(analyzer);
            iwConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            iwriter = new IndexWriter(directory, iwConfig);
            //写入索引
            for (int i = 0; i < 3; ++i)
            {
                int year = 2004 + i;
                Document doc = new Document();
              //  Field tem = new LongPoint("tem",100);
                doc.add(new TextField(fieldName, year + " happy new year", Field.Store.YES));
                doc.add(new LongPoint("date",  year * 10000 + 1111));
                iwriter.addDocument(doc);
            }
            // 加入一个干扰文档
            Document doc = new Document();
            doc.add(new TextField(fieldName, "happy new year", Field.Store.YES));
            doc.add(new LongPoint("date", 20141111));
            iwriter.addDocument(doc);
            iwriter.close();
 
            //搜索过程**********************************
            //实例化搜索器
            ireader = DirectoryReader.open(directory);
            isearcher = new IndexSearcher(ireader);
 
            String keyword = "happy new year";
            //使用QueryParser查询分析器构造Query对象
            QueryParser qp = new QueryParser(fieldName, analyzer);
            Query query = qp.parse(keyword);
            System.out.println("Query = " + query);
 
            //搜索相似度最高的5条记录
            TopDocs topDocs = isearcher.search(query, 5);
            System.out.println("命中：" + topDocs.totalHits);
            //输出结果
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            for (int i = 0; i < Math.min(5, scoreDocs.length); i++)
            {
                Document targetDoc = isearcher.doc(scoreDocs[i].doc);
                System.out.print(targetDoc.getField(fieldName).stringValue());
                System.out.print(" , " + targetDoc.getFields("date").length);
                System.out.println(" , " + scoreDocs[i].score);
            }
 
        } catch (CorruptIndexException e)
        {
            e.printStackTrace();
        } catch (LockObtainFailedException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ParseException e)
        {
            e.printStackTrace();
        } finally
        {
            if (ireader != null)
            {
                try
                {
                    ireader.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (directory != null)
            {
                try
                {
                    directory.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}