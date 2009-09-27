import math

def checksum(isbn):
    """ Calculate the checksum of an ISBN
    
    d1 + (d2 * 2) + (d3 * 3) + (d4 * 4) + (d5 * 5) +
    (d6 * 6) + (d7 * 7) + (d8 * 8) + (d9 * 9) % 11
    
    Returns: String checksum
    
    """
    
    # Checksum
    sum_ = 0
    
    # Length of integer
    length = int(math.log10(isbn))+1
    
    for i in range(1, length+1):
        multiplier = -i+length+1
        digit = (isbn/10**(i-1)) % 10
        new_sum_= sum_ + (digit*multiplier)
        #print i, "%d = %d + (%d*%d)" % (new_sum_, sum_, digit, multiplier)
        sum_ = new_sum_
    
    sum_ = sum_ % 11
    return (isbn, str(sum_) if sum_ < 10 else "X")

if __name__ == "__main__":
    n = 458136482l
    print checksum(n)
