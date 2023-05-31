
class Payment:
    def __init__(self, amount):
        self.amount = amount
        pass

class Check(Payment):
    

class Cash(Payment):
    def __init__(self, amount, cash):
        self.cashTendered = cash

class Credit(Payment):
    def __init__(self):
        pass

class Order:
    def __init__(self):
        pass
