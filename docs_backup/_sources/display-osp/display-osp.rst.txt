:orphan:

.. highlight:: java

Displaying Simulations using OSP
================================

You will use the **Open Source Physics** (OSP) library to display your physics
simulations. You've already used OSP (specifically the ``PlotFrame`` class) to
plot graphs and Riemann sums. This page will cover how to use OSP for animated
simulations.

`JavaDocs for OSP <https://kjergens.github.io/osp-5.1.0/out/html/index.html?overview-summary.html>`_

The Simulation Class
--------------------

The first step when making an OSP simulation is to create a class which
extends ``AbstractSimulation`` (`doc
<https://kjergens.github.io/osp-5.1.0/out/html/org/opensourcephysics/controls/AbstractSimulation.html>`__),
the abstract class from which all simulations inherit::

    public class Projectile1DApp extends AbstractSimulation {
        // ...
    }

You'll notice an error pop up; that's because ``AbstractSimulation`` has an
abstract method called ``doStep()`` which must be implemented inside of your
simulation class (the ``@Override`` annotation is a reminder that ``doStep()``
is implementing a method from its superclass)::

    @Override
    protected void doStep() {
        // ...
    }

``doStep()`` will be called repeatedly by OSP as your program runs; you will
update the particle's properties and display its new position inside of this
method.

Next, add the ``reset()`` and ``initialize()`` methods to ``Projectile1DApp``::

    @Override
    public void reset() {
        // ...
    }

    @Override
    public void initialize() {
        // ...
    }

As with ``doStep()``, you will never call these methods yourself. Rather, they
will be called by the superclass, ``AbstractSimulation``. Just as ``slice()``
and ``slicePlot()`` had specific implementations for each Riemann sum rule,
``doStep()``, ``reset()``, and ``initialize()`` have specific implementations
in your simulation. The ``reset()`` method will contain code which resets the
simulation's properties to their default values, while ``initialize()`` will
contain code to set up the simulation before it runs.

The last method you should add is a main method---the simulation class will
be the main class for your program. This method will tell OSP to set up
the simulation when the program starts::

    public static void main(String[] args) {
        SimulationControl.createApp(new FreeFallApp());
    }

