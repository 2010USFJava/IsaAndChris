package com.revature.service;

import java.util.List;

import com.revature.dao.SuperVillainDao;
import com.revature.model.SuperVillain;

public class VillainService {
	SuperVillainDao svdao = new SuperVillainDao();

	public SuperVillain loginGetVillain(String name, String superPower) {
		if (loginVerify(name, superPower)) {
			return svdao.getVillainByName(name);
		}
		return null;
	}

	public boolean loginVerify(String name, String superPower) {
		List<SuperVillain> villList = svdao.getAllVillains();
		boolean verify = false;
		for (SuperVillain vill : villList) {
			if (vill.getName().equals(name) && vill.getSuperPower().equals(superPower)) {
				verify = true;
			}
		}
		return verify;
	}

	public void insertNewVillain(SuperVillain vill) {
		svdao.insertSuperVillain(vill);
	}
}
