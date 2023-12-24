import z3

input_file = open("input.txt")

positions = []
velocities = []

for line in input_file:
    line = line.strip()
    pos, vel = line.split(" @ ")
    positions.append(tuple(map(float, pos.split(", "))))
    velocities.append(tuple(map(float, vel.split(", "))))

# variables
x = z3.Real('x')
y = z3.Real('y')
z = z3.Real('z')
velX = z3.Real('vx')
velY = z3.Real('vy')
velZ = z3.Real('vz')

s = z3.Solver()

for i, pos in enumerate(positions):
    x_i, y_i, z_i = pos
    velX_i, velY_i, velZ_i = velocities[i]

    # variable time
    time_i = z3.Real(f"time_{i}")

    # constraints
    s.add(x_i + velX_i * time_i == x + velX * time_i)
    s.add(y_i + velY_i * time_i == y + velY * time_i)
    s.add(z_i + velZ_i * time_i == z + velZ * time_i)

s.check()

print(s.model()[x].as_long() + s.model()[y].as_long() + s.model()[z].as_long())