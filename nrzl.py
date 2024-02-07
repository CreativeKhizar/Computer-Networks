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
s=0

lst=[int(i) for i in n]

if lst[0]==0:
    d.backward(h)
    s=0
else:
    d.forward(h)
    s=1

for i in lst:
    if i==0:
        if s==1:
            d.backward(2*h)
            s=0
        d.setheading(0)
        d.forward(w)
        d.setheading(90)
    else:
        if s==0:
            d.forward(2*h)
            s=1
        d.setheading(0)
        d.forward(w)
        d.setheading(90)
