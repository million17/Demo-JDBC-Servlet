package application.paging;

import application.sort.Sorter;

public interface Pageble {
	Integer getPage();

	Integer getOffset();

	Integer getLimit();
	
	Sorter getSorter();
}
