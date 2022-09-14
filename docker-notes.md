Docker is a virtualization tool
Docker does NOT create virtual machines - it creates something called a container.

A virtual machine is a simulation of an entire operating system.
A container, rather, reuses part of the parent computer's operating system and only looks like its operating system.
So, a container on Windows uses Windows' memory management, etc, system while it functions like Linux.

Why?

STANDARDIZED ENVIRONMENTS

We can pass standardized images around. Images are blueprints for containers.

Containers are also more efficient and lightweight than images, because they don't need to recreate an entire OS, only part of it.

We can also create our own images.
We can use a Dockerfile to create an image.

The process of converting our project into a docker container is called containerization.