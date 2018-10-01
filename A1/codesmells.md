# Markdown

Markdown is a plain-text file format. There are lots of programming tools that use Markdown, and it's useful and
easy to learn. Hash marks (the number sign) indicate headers. Asterisks indicate lists.

# Template

Use the following Code Smell template (copy and paste it at the end of this file and then edit it; don't include the "Begin template" or "End template" lines):

==== Begin template ====
## Code Smell: [Write the code smell name]

### Code Smell Category: [Write the code smell category name]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:

[In your own words, explain how this particular code smells.]

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]
==== End template ====

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
or their code needs fixing.

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