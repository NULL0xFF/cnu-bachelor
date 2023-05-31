# # Singleton

# class SingletonInstane:
#     # Implement Singleton Pattern Here!
#     pass

# class MyClass(metaclass=SingletonInstane):
#     pass

# class A:
#     pass

# if __name__ == "__main__":
#     m1 = MyClass()
#     m2 = MyClass()
#     print(m1 == m2)

#     n1 = A()
#     n2 = A()
#     print(n1 == n2)


# class Box:
#     def __init__(self):
#         print("Box")
#         self.width = 0

#     def set_width(self, x):
#         self.width = x

#     @staticmethod
#     def get_default_width():
#         return 0

#     @classmethod
#     def c_sum(cls, a, b):
#         return a+b

#     @staticmethod
#     def s_sum(a, b):
#         return a+b


# print(Box.s_sum(10, 20))
# print(Box.c_sum(10, 20))

# class SingletonInstane:
#     __instance = None

#     @classmethod
#     def __getInstance(cls):
#         return cls.__instance

#     @classmethod
#     def instance(cls, *args, **kargs):
#         cls.__instance = cls(*args, **kargs)
#         cls.instance = cls.__getInstance
#         return cls.__instance


# class Student(BaseClass, SingletonInstane):
#     def __init__(self, name, grade):
#         this.name = name
#         this.grade = grade

# class Singleton(type):
#     _instances = {}

#     def __call__(cls, *args, **kwargs):
#         if cls not in cls._instances:
#             cls._instances[cls] = super(
#                 Singleton, cls).__call__(*args, **kwargs)
#         return cls._instances[cls]


# class Student(metaclass=Singleton):
#     def __init__(self, name, grade):
#         this.name = name
#         this.grade = grade


# me = Student.instance("Ji Myoung Ha", 2)
# print(me.name)
# print(me.grade)
class Singleton(type):
    def __init__(cls, name, bases, attrs, **kwargs):
        super().__init__(name, bases, attrs)
        cls._instance = None

    def __call__(cls, *args, **kwargs):
        if cls._instance is None:
            cls._instance = super().__call__(*args, **kwargs)
        return cls._instance


class MyClass(metaclass=Singleton):
    def __init__(self, name, grade):
        self.setter(name, grade)

    def setter(self, name, grade):
        self.name = name
        self.grade = grade

    def show(self):
        print("Name : {} \t Grade : {}".format(self.name, self.grade))


if __name__ == "__main__":
    m1 = MyClass("a", "b")
    m2 = MyClass("c", "d")

    # m2.setter("c", "d")

    m1.show()
    m2.show()
