def special_data_table( number_of_slots, values, find_item ) :
	####### DO NOT MODIFY BELOW #######
	myTable = MySpecialTable(number_of_slots)
	for val in values:
		myTable.add_item(val)

	return myTable.find_item(find_item)
	####### DO NOT MODIFY ABOVE #######

class MySpecialTable():
		def __init__(self, slots):
			self.slots = slots
			self.table = []
			self.create_table()

		def hash_key(self, value):
			return value % self.slots

		def create_table(self):
            for i in range(self.slots):
                self.table.append([])

		def add_item(self, value):
            hKey = self.hash_key(value)
            list = self.table[hKey]
            list.add(value)
			

		def find_item(self, item):
			hKey = self.hash_key(item)
            list = self.table[hKey]
            for x  in list:
                if(x == item):
                    return hKey
            
            return -1

