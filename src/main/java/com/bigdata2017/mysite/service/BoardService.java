package com.bigdata2017.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigdata2017.mysite.repository.BoardDao;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
}
