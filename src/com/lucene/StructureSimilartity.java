package com.lucene;

import org.apache.lucene.index.FieldInvertState;
import org.apache.lucene.search.CollectionStatistics;
import org.apache.lucene.search.TermStatistics;
import org.apache.lucene.search.similarities.Similarity;

public class StructureSimilartity extends Similarity {

	@Override
	public long computeNorm(FieldInvertState arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SimScorer scorer(float arg0, CollectionStatistics arg1, TermStatistics... arg2) {
		System.out.println(arg0+"    "+arg1.field()+"    "+arg1.toString()+"     "+arg2.toString());
		return null;
	}

}
