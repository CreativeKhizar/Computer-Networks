import turtle

n=input("Enter the bits : ")

d=turtle.Turtle()
d.forward(1000)
d.backward(1000)
d.setheading(90)
d.forward(500)
d.backward(1000)
d.forward(500)

h=30
w=20

lst=[int(i) for i in n]

d.setheading(90)
d.forward(h)
s=1
for i in lst:
    if i==1:
        if s==1:
            d.backward(2*h)
            s=0
        else:
            d.forward(2*h)
            s=1
        d.setheading(0)
        d.forward(w)
        d.setheading(90)
    else:
        d.setheading(0)
        d.forward(w)
        d.setheading(90)
