def get_rows (a):
	return len(a)

def get_cols (a):
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
