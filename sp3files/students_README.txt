Your SP3 support files contain the following:

   1. /src  This contains java files you will need:

       * SLMSTestInterface.java:  the interface-definition of your test interface

       * Test0.java, Test1.java etc: the test files; you have to pass all of them

       * YourTestInterfaceFactory.java: you need to modify this, see SP3 Description

       * SLMSTI.java: my implementation of the test-interface; modify
         this... you need to provide something like this.

       * utils/SimpleDate.java: simple representation of date; used by
         the test-interface. You can also use it to represent your
         dates.

   2. /libs contains junit.jar, in case you don't have it yet. You
   should already have it in your Eclipse though.

   3. /docs the Javadocs documentation of the above Java files. Of
   course you can also see the documentation in the source code
   itself.
