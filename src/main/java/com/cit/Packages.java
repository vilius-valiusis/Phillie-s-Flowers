package com.cit;

import java.util.ArrayList;

public class Packages {

	private ArrayList<Package> packages;
	
	public Packages(ArrayList<Package> packages ) {
		
		this.packages=packages;
		
	}
	
	
	public ArrayList<Package> getPackages(){
		
		//pull all packages from database
		
		
		
		return this.packages;
	}
	
	public void addPackage(Package p) {
		//add package to database
		
		
	}
	
	public Package getPackage(){
		//retrieve a package from database
		Package p = null;
		return p;
	}
}
