# RUBIX Cube 

Rubix cube has 6 sides.
Each side has 9 squares.
The goal is to make each side made up of only one color.


# Anatomy of RUBIX cube

The cube is made of 26 smaller cubes.

## Types of smaller cubes

There are 3 types of cubes.

* Corner cubes - have 3 sides exposed
* Edge cubes - have 2 sides exposed
* Center cubes - have 1 side exposed

## Colors of the Rubix cube

Let us assume that the 6 six sides of the Rubix cube are painted with unique colors.
The six unique colors are as follows,

|    | color |
|----|-------|
| Y  | Yellow|
| R  | Red   |
| G  | Green |
| O  | Orange|
| B  | Blue  |
| W  | White |


## Unique colors of 26 cubes

Table below describes the "final" state of the rubix cube.
Also, Each cube is painted with unique set of colors.

|x  |   |   |   |   |
|---|---|---|---|---|
|Top|   |YYY<br>YYY<br>YYY|   |   |
|   |left  |front  |right  |back  |
|Sides|RRR<br>RRR<br>RRR|GGG<br>GGG<br>GGG|OOO<br>OOO<br>OOO|BBB<br>BBB<br>BBB|
|Bottom|   |WWW<br>WWW<br>WWW|   |   |

### Colors of corner cubes

L - left, R- Right, T - Top, B - Bottom, F - front, K - Back

**Corner Cubes**

| cube | colors |
|------|--------|
|LTF   |RYG     |
|FTR   |GYO     |
|LTK   |RYB     |
|RTK   |OYB     |
|||
|LFB   |RGW     |
|FRB   |GOW     |
|LKB   |RBW     |
|RKB   |OBW     |

**Edge Cubes**

| cube | colors |
|------|--------|
|LT    |RY      |
|FT    |GY      |
|RT    |OY      |
|KT    |BY      |
|LB    |RW      |
|FB    |GW      |
|RB    |OW      |
|KB    |BW      |
|      |        |
|LF    |RG      |
|FR    |GO      |
|RK    |OB      |
|KL    |BR      |

**Center Cubes**

| cube | colors |
|------|--------|
|L    |R      |
|F    |G      |
|R    |O      |
|K    |B      |
|T    |Y      |
|B    |W      |

## Impossible Color combinations

Based on the above table, certain combination of colors are not possible.
For example, there can never be RGO, RWO, WGY, WOY, GOB etc.
Basically, colors from opposite sides cannot be combined.
Same goes for edges that are opposite to each other.
e.g., There cannot be RO, GB and YW.

## Movement of sides

As we see from the above table, many colors  are locked, to the side of corner and edge cubes. These color combinations cannot move independently.


## Cube type and possible movements

Each type of cube can only move in certain direction. 
Movements in all directions are not possible.


| Cube Type  | Possible Movement   | Sides exposed |
|------------|---------------------|---------------|
| Corner     | to 3 other corners  | 3             |
| Edge       | to 6 other edges    | 2             | 
| center     | to 4 centers        | 1             |


# Validation of color combinations






