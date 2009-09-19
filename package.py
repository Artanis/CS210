#! /usr/bin/env python

import sys
import zipfile
from glob import glob

def package_assignment(name):
	""" Creates a zip file containing the assignment ready to turn in
	
	Packages all .java files as well as README
	
	"""
	
	assignment = name.replace(".","-")
	arcname = "Erik_Youngren_-_Assignment_%s" % (assignment,)
	
	package = zipfile.ZipFile("%s.zip" % (arcname,), "a")
	
	filelist = glob(name+"/*.java")
	filelist.extend(glob(name+"/README"))
	
	print "Creating %s.zip" % (arcname,)
	for f in filelist:
		arcfile = "%s%s" % (arcname, f[f.find("/"):])
		package.write(f, arcfile)
		print "    %s" % (arcfile,)

if __name__ == "__main__":
	package_assignment(sys.argv[1])
