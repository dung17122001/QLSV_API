package com.kltn.api.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.kltn.api.entity.LopHocPhan;

public interface LopHocPhanService {
	public void saveOrUpdate(LopHocPhan lopHocPhan);
	public List<LopHocPhan> getAllLopHocPhan();
	public LopHocPhan getLopHocPhanById(String id);
	public String autoId();
	public List<LopHocPhan> getLopHocPhanTheoMaHocPhan(String maHP,String maHK);
	
}
