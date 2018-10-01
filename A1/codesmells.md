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
