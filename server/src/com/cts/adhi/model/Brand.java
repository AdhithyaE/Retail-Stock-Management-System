package model;

import java.util.ArrayList;
import java.util.List;

public class Brand {
	private String brandId;
	private String brandName;
	public Brand(String brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}
	public Brand() {
		// TODO Auto-generated constructor stub
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public List<Brand> prefil() {
		List<Brand> list=new ArrayList<Brand>();
		list.add(new Brand("SAM001", "SAMSUNG"));
		list.add(new Brand("LG001", "LG"));
		list.add(new Brand("VU001", "VU"));
		list.add(new Brand("MI001", "REDMI"));
		list.add(new Brand("BO001", "BOULT"));
		list.add(new Brand("OP001", "ONEPLUS"));
		list.add(new Brand("RM001", "REALME"));
		list.add(new Brand("SO001", "SONY"));
		list.add(new Brand("JBL001", "JBL"));
		list.add(new Brand("CA001", "CANON"));
		list.add(new Brand("NI001", "NIKON"));
		list.add(new Brand("GP001", "GO PRO"));
		list.add(new Brand("IP001", "APPLE"));
		list.add(new Brand("VI001", "VIVO"));
		
		return list;
	}
}

