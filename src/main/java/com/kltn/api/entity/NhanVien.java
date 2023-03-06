package com.kltn.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class NhanVien {
	@Id
	private String maNhanVien;
	@Column( columnDefinition = "nvarchar(255)")
	private String tenNhanVien;
	@Column( columnDefinition = "nvarchar(255)")

	private Boolean gioiTinh;
	
	@Column( columnDefinition = "nvarchar(255)")
	private String trangThai;
	
	@Embedded
	private HoSo hoSo;
	
	@ManyToOne
    @JoinColumn(name = "maKhoa")
	private Khoa khoa;
	
	
	@OneToOne
    @JoinColumn(name = "maChucVu")
	private ChucVu chucVu;
	
	
}