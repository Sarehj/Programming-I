# A model of a polyline — vertices stored in a vector

# A) A model of a planar point
A planar point (a point on a two-dimensional plane) has a name and coordinates.
The coordinates are integer numbers.

A point can be defined by a name and two coordinates. It is also possible to define a point relative another point — a copy can be made.

It is also possible to create a character string that represents a point. This string could be on the form (A 3 4). The name and coordinates of a point can be obtained. The coordinates can be modified, one coordinate at the time. The distance between two points can be computed. Two points can be compared for equality.

A model of a planar point is to be created; (class called Point)

# B) A planar polyline
A polyline is a geometrical figure consisting of a series of connected line segments (edges). The endpoints of these line segments are the vertices of the polyline.

A polyline is defined by its vertices, its colour and its width. An empty polyline has no edges.

One can create a character string that represents a polyline. This string can be on the form {[(A 3 4)(B 1 2)(C 2 3)(D 5 1)], black, 1}. The vertices, colour, width and length of a polyline can be obtained. Colour and width can be modified. The shape of a polyline changes when its sequence of vertices is modified. One can add a new vertex to the polyline — either at the end or in front of a named vertex. It is also possible to remove a named vertex.

# C) Create and use polylines
In a program called SelectPolyline, create and use polylines of type Polyline.

A number of random polylines are created and presented. Each polyline has a random number of vertices and the colour is either blue, red or yellow. The vertices are named by single, uppercase letters from the english alphabet (A–Z). The names are chosen randomly but two vertices can not have the same name. The program determines and shows the shortest of the yellow polylines.
