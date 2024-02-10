import turtle

n=input("Enter the bits : ")
d=turtle.Turtle()

d.forward(1000)
d.backward(1000)
d.setheading(90)
d.forward(500)
d.backward(1000)
d.forward(500)

h=50
w=30
d.forward(h)
d.setheading(0)
s=1

for i in n:
    if i=="1":
        if s==1:
            d.forward(w)
            d.setheading(90)
            d.backward(2*h)
            d.setheading(0)
            d.forward(w)
            s=0
        else:
            d.setheading(90)
            d.forward(2*h)
            d.setheading(0)
            d.forward(w)
            d.setheading(90)
            d.backward(2*h)
            d.setheading(0)
            d.forward(w)
    else:
        if s==0:
            d.forward(w)
            d.setheading(90)
            d.forward(2*h)
            d.setheading(0)
            d.forward(w)
            s=1
        else:
            d.setheading(90)
            d.backward(2*h)
            d.setheading(0)
            d.forward(w)
            d.setheading(90)
            d.forward(2*h)
            d.setheading(0)
            d.forward(w)

            
            
            
            
            
            
