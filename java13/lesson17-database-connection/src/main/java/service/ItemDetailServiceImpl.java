package service;

import dao.ItemDetailDao;
import dao.ItemDetailDaoImpl;

public class ItemDetailServiceImpl implements ItemDetailService{
	private ItemDetailDao itemDetailDao;
	public ItemDetailServiceImpl() {
		itemDetailDao = new ItemDetailDaoImpl();
	}
	@Override
	public boolean doTransfer() {
		return itemDetailDao.doTransfer();
	}

}
