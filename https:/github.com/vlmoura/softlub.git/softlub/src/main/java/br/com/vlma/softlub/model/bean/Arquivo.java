package br.com.vlma.softlub.model.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

import com.sun.swing.internal.plaf.basic.resources.basic;

@Entity(name="arquivo")
public class Arquivo implements Serializable{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = -7730772595591143649L;

		public Arquivo() {
			// TODO Auto-generated constructor stub
		}
		
		public Arquivo(File pFile, String pName, String pContentType) {
			setContent(pFile);
			setContentType(pContentType);
			setName(pName);
		}
		
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@Lob
		@Column(nullable=false)
		private byte[] content;
		
		@Column(nullable=false)
		private String name;
		
		@Column(nullable=false)
		private String contentType;
		
		//Getters e Setters - BEGIN
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		@Lob
		public byte[] getContent() {
			return content;
		}
		public void setContent(byte[] content) {
			this.content = content;
		}
		
		public void setContent(File pFile) {
			 
			try {
				byte[] bytes = new byte[(int)pFile.length()];
				FileInputStream fileInputStream = new FileInputStream(pFile);
				fileInputStream.read(bytes);
				fileInputStream.close();
				this.content = bytes;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContentType() {
			return contentType;
		}
		public void setContentType(String contentType) {
			this.contentType = contentType;
		}	
		
		//Getters e Setters - END

}
