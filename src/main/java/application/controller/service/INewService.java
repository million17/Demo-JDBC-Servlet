package application.controller.service;

import java.util.List;

import application.model.New;

public interface INewService {
	List<New> findByCategoryId(Long categoryId);
}
