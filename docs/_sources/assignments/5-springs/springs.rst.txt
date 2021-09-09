Springs
=======

You've learned about springs in your physics class, and now you can use that
knowledge to make a model of a spring. While for your class you used ideal
springs, you can actually give your springs mass in the model you build in
this class.

Bungee Cord
-----------

A bungee cord is elastic -- if you stretch it, it snaps back to its original
length. Therefore, one way to model a bungee cord is to represent it as a
series of springs.

.. note::

    Bungee cords can be stretched, just like springs, but cannot be
    compressed. Therefore, make sure that your bungee cord doesn't take
    compression into consideration, or you might encounter resonance and a
    bungee cord that behaves oddly.


.. admonition:: Exercise

    What is the effective spring constant of a series of springs?

.. figure:: springsPic.png
    :width: 60 %
    :align: center

    A drawing of what your model would look like

The above drawing represents how you shoul construct your bungee cord. Think
about the clases that you might need to write. What are the components of a
bungee cord? What functions should you include in your classes?

Instead of writing entirely new classes, you can reuse your old ``Particle``
class.

Assignment
----------

Unlike your previous assignments, you will not do the base assignment at the
same time as the extension. Instead, you will do the base, and return to the
extension after the **Orbital** project. In order to prepare for this break,
you should make sure to document your code clearly and thoroughly.

Base
^^^^^^

There are two components to the base assignment. Just as with the
**Projectile** assignment, the base should not take nearly as long as your
extension, and the first part of the base assignment should be far faster than
the second.

Part 1
~~~~~~

Make a 1D spring. You should be able to input parameters like mass, number of
springs/particles, and length. Use your spring to make a bungee cord, and then
solve this problem:

There is a bridge **100 ft** above a river. If a **50 kg** person wants to go
bungee jumping off of the bridge, using a **40 m** long bungee cord with a
mass of **10 kg**, what should the spring constant of the overall bungee cord
be in order for the jumper to just barely graze the water?

In addition to using your model to solve the question, you should try to
answer the question yourself using what you know about springs already. Write
up your theoretical answer, explaining how you got to your conclusion. In
addition, explain any deviation between your theoretical answer and the answer
you get from your model.

Part 2
~~~~~~

Make a 2D spring, and then combine the springs end to end in order to make a
string. Once you have your string, send a wave down the string in order to
make a transverse wave. Your goal is to mimic the motion of a cello string
once it is plucked.

.. note::
    Cello strings are not at their equilibrium length when they are on a
    cello. Instead, they are pulled taut. This means that when you "pluck"
    your string in your model, each of the springs should be stretched past
    its equilibrium length. This stretching should eliminate some of the
    horizontal motion that sometimes occurs between the point masses.


