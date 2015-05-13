package com.gred.easy_car.web.entity;

import java.util.List;

/**
 * 
 * @ClassName: CarBrand   
 * @Description: 车品牌实体
 * @author WangJianbin  
 * @date 2015年5月13日 下午3:18:49   
 *
 */
public class CarBrand {

	
	private String carBrandFirstLetter;
	
    private String carBrandName;

    private byte[] carBrandIcon;
    
    private String carBrandIconPicName;
    
    private List<CarBrandType> carBrandTypeList;


    
    

	/**
	 * @return the carBrandIconPicName
	 */
	public String getCarBrandIconPicName() {
		return carBrandIconPicName;
	}

	/**
	 * @param carBrandIconPicName the carBrandIconPicName to set
	 */
	public void setCarBrandIconPicName(String carBrandIconPicName) {
		this.carBrandIconPicName = carBrandIconPicName;
	}

	/**
	 * @return the carBrandTypeList
	 */
	public List<CarBrandType> getCarBrandTypeList() {
		return carBrandTypeList;
	}

	/**
	 * @param carBrandTypeList the carBrandTypeList to set
	 */
	public void setCarBrandTypeList(List<CarBrandType> carBrandTypeList) {
		this.carBrandTypeList = carBrandTypeList;
	}

	/**
	 * @return the carBrandFirstLetter
	 */
	public String getCarBrandFirstLetter() {
		return carBrandFirstLetter;
	}

	/**
	 * @param carBrandFirstLetter the carBrandFirstLetter to set
	 */
	public void setCarBrandFirstLetter(String carBrandFirstLetter) {
		this.carBrandFirstLetter = carBrandFirstLetter;
	}

	public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName == null ? null : carBrandName.trim();
    }

    public byte[] getCarBrandIcon() {
        return carBrandIcon;
    }

    public void setCarBrandIcon(byte[] carBrandIcon) {
        this.carBrandIcon = carBrandIcon;
    }
}