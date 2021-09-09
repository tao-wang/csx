.. highlight:: java

Matrix Assignment
=================

  .. figure:: Matrix_definition.png
   :width: 60 %
   :align: center

`Matrices <https://en.wikipedia.org/wiki/Matrix_(mathematics)>`_ have many
different uses and applications both in math and science. In fact, many of you
will use matrices in physics in order to solve systems of
equations.

In this assignment, you will write a class to find the inverse of a given matrix, if in fact the inverse exists. The **inverse** of a matrix is one such that when multiplied to the original matrix produces the **identity matrix** (a square matrix of all zeros except for ones along the diaganol). You can read about why the inverse is useful `here <https://www.mathsisfun.com/algebra/matrix-inverse.html>`_ .

There are various techniques for finding the inverse of a matrix. This assignment asks you to find it using `elementary row operations <https://www.mathsisfun.com/algebra/matrix-inverse-row-operations-gauss-jordan.html>`_ . Each elementary row operation will be a method in your Matrix class, except for ``invert()`` which will call the other methods. 

As with the Riemann Sums assignment, there is `a Matrix JavaDoc
<../../_static/matrix-javadoc/Matrix.html>`_ to guide you. You will also create a ``MatrixApp`` class to test your ``Matrix`` and a ``MatrixTest`` test class with several test cases.

This assignment can seem very daunting at first. Before you decide what
instructions you want to give your computer, you have to determine how you
would manipulate a matrix first. So, we recommend that you start by trying to
modify a few different matrices into the identity matrix by hand.


.. note::
    Except for the methods that start with ``set__``, none of the methods 
    should actually modify the original ``Matrix``. Instead, they 
    return an entirely new ``Matrix``. Make sure, when you are implementing 
    these methods, that you are not modifying the original ``Matrix``, but
    rather the ``Matrix`` that you will return.

It will be very important to identify your edge cases when you are testing.
Again, much of the work of this project will be to refine your algorithm once
you think you know what the basic logic should be. How will you handle
non-square matrices? Uninvertible matrices?

Additionally, think about how you can tell your program is working correctly.
It's hard to look at an inversion of a matrix and tell if it's correct, so try
to use the properties of inverse matrices in order to make testing easier.
Also remember that it is very hard to naturally come by a singular (i.e.
uninvertable) matrix by chance, so you might want to intentionally create
singular matrices.


Matrix Assignment
-----------------

Remember to **document as you go.** Each method you write should
have a documentation comment (ideally in the JavaDoc format)
before it::

    /**
     * [DESCRIPTION OF WHAT THE METHOD DOES]
     *
     * @param left [DESCRIPTION OF THE 'left' PARAMETER]
     * @param right [DESCRIPTION OF THE 'right' PARAMETER]
     * @param subintervals [DESCRIPION OF THE 'subintervals' PARAMETER]
     * @return [DESCRIPTION OF WHAT THE METHOD RETURNS]
     */
    public double calculateDeltaX(double left, double right, int subintervals) {
        // the actual method
    }

Base Assignment
----------------  

1. Matrix Class
^^^^^^^^^^^^^^^^^^^  
.. admonition:: Exercise

  **Summary**: Create a Matrix object that performs common matrix operations.

  #. In src folder, create a package namespace called ``com.[yourname].matrix``.
  #. In ``matrix`` create a class called ``Matrix``.
  #. Add a ``private`` attribute called ``matrix`` that is a two-dimensional array of ``double`` s.
  #. Write the Matrix constructors according to the `Matrix JavaDoc <../../_static/matrix-javadoc/Matrix.html>`_ . 
  #. Implement the rest of the methods in the `Matrix JavaDoc <../../_static/matrix-javadoc/Matrix.html>`_ .
  #. Optionally, create other helper methods to aid in inverting a matrix.

2. Test Classes
^^^^^^^^^^^^^^^^^
.. admonition:: Exercise

  **Summary**: Test the Matrix methods.

  #. In the ``test`` folder, create a class called ``MatrixTest`` and import all the necessary JUnit libraries.
  #. In the class, but outside of any methods, create a global Matrix variable of some size, e.g. ``Matrix matrix = new Matrix(10, 10);``
  #. Write several test methods to test every method in the ``matrix`` object. You can check the answers to an inverse matrix using a `matrix inverse calculator <https://matrix.reshish.com/inverse.php>`_.

  When all of the tests pass you are done with this exercise.

3. MatrixApp
^^^^^^^^^^^^^^^^^
.. admonition:: Exercise

  **Summary**: Use the Matrix object.

  #. Back in ``matrix``, create a new class called ``MatrixApp``.
  #. Create a ``main`` method.
  #. Create an example ``Matrix`` object and print it to the console. Then print its inverse, like this:

  .. figure:: matrix.png
   :width: 70 %
   :align: center


Extensions
------------

After the base assignment is done, do more with your ``Matrix``. You can use one of the ideas below or think of your own.

.. admonition:: Extension Ideas

  #. Another way to find the inverse of a matrix by using its `determinant <https://www.mathsisfun.com/algebra/matrix-determinant.html>`_. Implement methods to find the determinant and use it to find the inverse. 
  #. Use your ``Matrix`` class to interpolate a polynomial given a set of points. Think about whether given *n* points what is the degree of the polynomial you will need to make.
  #. See if you can find a relationship between the derivative of an accumulation function (recall the Riemann sum assignment), and the accumulation function of the derivative of the function.
  #. Use your ``Matrix`` class to balance a chemical equation. See this research paper on `Balancing of Chemical Equations using Matrix Algebra <https://iiste.org/Journals/index.php/JNSR/article/viewFile/20721/21315>`_.

  You could also make a GUI. Even if you choose not to make a GUI, you should definitely have a way in which people can input their own polynomials through a command line interface.

