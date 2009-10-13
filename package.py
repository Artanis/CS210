#! /usr/bin/env python

import os
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
    filelist.extend(glob(name+"/NOTE"))
    
    print "Creating %s.zip" % (arcname,)
    for f in filelist:
        arcfile = "%s%s" % (arcname, f[f.find("/"):])
        
        # Convert files to DOS line-ends. D:
        os.system("unix2dos "+f)
        
        # Write to archive
        package.write(f, arcfile)
        
        # Convert files back to Unix line-ends. :D
        os.system("dos2unix "+f)
        
        print "    %s" % (arcfile,)

if __name__ == "__main__":
    package_assignment(sys.argv[1])
