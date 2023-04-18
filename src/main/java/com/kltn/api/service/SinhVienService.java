package com.kltn.api.service;

import java.util.List;

import com.kltn.api.entity.NhanVien;
import com.kltn.api.entity.SinhVien;

public interface SinhVienService {
	public void saveOrUpdateSinhVien(SinhVien sinhVien );
	public List<SinhVien> getAllSinhVien();
	public SinhVien getSinhVienById(String id);
	public Long countSVByLopHoc(String classID);
	public String autoId();
	public List<SinhVien> timKiemSinhVien(String textSearch);
	public int countSinhVienByLHP(String maLHP);
	
	public int countSinhVienByNTH(String maNTH);

}
