# List of code smells

## Code Smell: Long Method

### Code Smell Category: Bloater

### List of classes and line numbers involved:

* WarehouseSimulation class (lines 41-96 of the "start" method)


### Description:

This method has approximately 45 lines of code. Not only does this make it difficult for me as the replacement
programmer to trace the code and what each line does, it makes it very tedious to study the code and find the mistakes
that are causing the program to not return the expected and desired result. Shorter methods allow you to catch mistakes
easily. The programmer took the lazy way and just kept extending the method. There were a couple other methods between
17-20 lines in the TranslationTable class and the WarehouseManager class, but I deemed their code to be short  and
clear enough to be understood easily.

### Solution:

The easiest solution would be to remove the excessive loop statements in the code and create separate methods for them
by 'Extracting the Method' into a new one. This would allow mistakes to be visible in shortened methods and assist in
figuring out why the program isn't running correctly. You can also decompose the conditionals, of which there are
several, by creating separate methods for the statements in the "if" and "else" brackets.


## Code Smell: Comments

### Code Smell Category: Dispensables

### List of classes and line numbers involved:

* Warehouse Simulation class (most of lines 13-40)
* Order class (most of lines 7-46)
* OrderListManager class (most of lines 7-58)
* GenericPathSoftware class (lines 10-15)
* PickerOrderList class (most of lines 6-96
* SequencerOrderList class (most of lines 6-96)
* TranslationTable class (most of lines 14-23 and 45-51)
* WarehouseManager class (most of lines 10-61, 76-80, 87-92, 108-113, 128-135, 156-161, and 179-186)

### Description:

When I first skimmed through the code, the smell that was most obvious and, perhaps, most annoying was from the number
of comments. While a comment here and there is not too much of an issue, in many of the aforementioned classes, the
number of lines of comments match or exceed the lines of code. Not only are the eye-watering comments making it
difficult to discern the actual code, the sheer number of them hint at the fact that there is something suspicious about
the code itself. Comments are often used excessively by programmers who are too hasty or careless and try to hide their
flawed code.

### Solution:

Delete the comments that are detailing the methods purpose and the parameters. Rename the parameters and methods that
are unclear. If the names of the parameters, variables, and methods are written with reasonable thought, there is no need
for comments to explain. As for the comments that describe what each part of the code is doing, well-written code should
be of no difficulty for other programmers to read so either the programmer thinks that no one else is as smart as them
or their code needs fixing. Either way, the comments need to be removed.


## Code Smell: Lazy Class

### Code Smell Category: Dispensables

### List of classes and line numbers involved:

* GenericPathSoftware class (all lines)

### Description:

This is supposed to be a mock version of the actual shortest path software that the warehouse already has installed.
However, because the programmer moved on before finishing it, this class remains useless and a textbook example of a
lazy class. The comments state that connecting to the actual shortest path software is a to-do which is helpful but
doesn't explain the need for this class at the moment. The setOrder method in it takes the pickerOrderList as a parameter
but doesn't even use it, resorting to merely printing "->Order list set by generic software".

### Solution:

I would attach the setOrder method to a different class just for reference. Of course, as the programmer, I have
to establish connection between my program and the already created generic software, but, when I get to that, I can
create a relevant class. In the meantime, I would delete this whole class.


## Code Smell: Large Class

### Code Smell Category: Bloaters

### List of classes and line numbers involved:

* WarehouseManager class (13-202)

### Description:

To put it simply, this class 189 lines of code. There are also 10 instance variables in the class. The class is too
large for a programmer to alter a variable or a method without having to comb through the rest of the class and the
other classes as well.

### Solution:

If a class is large but the variables and methods are completely relevant and a necessary part of the class, this smell
can possibly be overlooked. However, in this case, the class has methods for both picking AND sequencing as well as
instance variables for both. Therefore, the easiest solution for this particular smell is to extract the code for
picking or sequencing and put it in a new class. That way, the methods and variables still exist but the class isn't
an unacceptable length. Furthermore, this makes it easier to spot code that is not behaving as intended.


## Code Smell: Switch Statements

### Code Smell Category: Object-Orientation Abusers

### List of classes and line numbers involved:

* WarehouseSimulation class (lines 53-89)

### Description:

While it may seem odd that I'm flagging those lines for a Switch Statement code smell when there's no "Switch" operator,
according to SourceMaking, a complex sequence of "if" statements is part of this code smell. There are a staggering total of
10 "if", "else if", and "else" statements in those 30-odd lines of code. It is tedious to trace code through so many
conditions and it is a real waste of using an object-oriented language like Java that lets you create classes and
subclasses as often as you want. Furthermore, using so many conditionals casts a programmer in a poor light as it shows
either a lack of comprehension of the benefits of object-orientation or sheer laziness, both of which do a programmer
no good career-wise. It also makes the code difficult to alter should it not work as intended, as in this case.

### Solution:

The solution for this is to use the benefits of polymorphism. Instead of using an inane amount of conditionals, create
subclasses within the class that match cases of the conditionals. Using this code as an example, the subclasses would
be divided by nextEvent, pickerOrderList.size, and endsWith. This would shorten the code considerably, make it easier
to trace, and make it easier to spot the flaws that are interfering with the program