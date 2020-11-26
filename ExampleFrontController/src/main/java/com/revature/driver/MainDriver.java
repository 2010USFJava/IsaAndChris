package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.SuperVillainDao;
import com.revature.model.SuperVillain;

public class MainDriver {

	public static void main(String[] args) {
		SuperVillain s1 = new SuperVillain("Carl", "Beige", 50);
		SuperVillain s2 = new SuperVillain("Batman", "Money", 1000000000);
		SuperVillain s3 = new SuperVillain("Deadpool", "Sarcasm", 1);
		List<SuperVillain> villList = new ArrayList<SuperVillain>();
		villList.add(s1);
		villList.add(s2);
		villList.add(s3);
		insertVills(villList);
	}

	public static void insertVills(List<SuperVillain> villList) {
		SuperVillainDao svdao = new SuperVillainDao();
		for(SuperVillain v : villList) {
			svdao.insertSuperVillain(v);
		}
		System.out.println(svdao.getAllVillains());
	}
}
