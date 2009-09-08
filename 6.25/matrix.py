""" Multiply two matrices together

Under normal circumstances I'd have made a matrix type and written the
multiply in under the __mul__ magic class method, enabling the use of
the multiplicative operator in multiplying two matrices, but since this
is just a proof of concept for a Java assignment (and I have no
intention of delving into type creation in Java at this point in time,
this is just left as a simple script.

Hard-coded parameters:
    Matrix a:
        [1,2]
        [3,4]
    Matrix b:
        [1,1]
        [1,1]

Result:
    Matrix c:
        [3,3]
        [7,7]

"""

def get_rows (matrix):
	""" Returns the number of rows in a matrix
	
	Really just the length of a list, a wrapper for
	
	    len(a)
	
	Here for completeness, paired with the get_cols function
	
	Named Arguments:
	* matrix -- any list, tuple, or dict object
	
	Returns number of rows in matrix
	
	"""
	
	return len(matrix)

def get_cols (matrix):
	""" Returns the number of columns in the matrix.
	
	Counts length of each row in matrix. If the matrix is ragged,
	returns -1. If the matrix is rectangular returns the number of
	columns.
	
	Named Arguments:
	* matrix -- any list of lists, tuple of tuples, or dict of dicts.
	
	Returns number of columns in matrix, or -1 if matrix is ragged
	
	"""
	
	result = None
	for i in a:
		c = len(i)
		if result is not None and c is not result:
			return -1
		result = c
	return result

a = [[1,2],
	 [3,4]]

b = [[1,1],
	 [1,1]]

cols = get_cols(a)
rows = get_rows(b)

c = [0] * rows
for i in range(rows):
	c[i] = [0] * cols

for i in range(cols):
	print "%d" % i
	for j in range(rows):
		print "  %d" % j
		for k in range(cols):
			print "    %d" % k
			try:
				print "        c[%d][%d] += a[%d][%d] * b[%d][%d]" % \
					(i, j, i, k, k, j)
				
				print "        c[%d][%d] += %d * %d" % \
					(i, j, a[i][k], b[k][j])
				
				c[i][j] += (a[i][k] * b[k][j])
			except IndexError:
				pass
			
			print "        c[%d][%d] = %d" % (i, j, c[i][j])

print a
print b
print c
