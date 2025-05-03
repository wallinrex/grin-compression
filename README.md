# Project: Grin Compression

Authors: Rex Wallin

## Resources

*   Java BiConsumer Docs: https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html
*   Java Map Docs: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
*   Java PriorityQueue Docs: https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html
*   Java Stack Docs: https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html

## Revision Log

commit 68eb820943d0c3ff91269c02c3330b0e6cf2d220 (HEAD -> main)
Author: wallinrex <wallinrex@gmail.com>
Date:   Fri May 2 19:34:34 2025 -0500

    Made sure decode will stop when in is empty

commit aabdb9fcde3bebbed907e7cc575ec8c32d3ed504 (origin/main, origin/HEAD)
Author: wallinrex <wallinrex@gmail.com>
Date:   Fri May 2 19:09:57 2025 -0500

    Made sure checkstyle was good

commit 695619da72a638ecead0dde428cee196ffadf23b
Author: wallinrex <wallinrex@gmail.com>
Date:   Fri May 2 00:02:45 2025 -0500

    Fixed encode (I think)
    
    Also fixed checkstyle stuff

commit 5ff464b95dc20e22b7e711520ff5fd752b3a7a11
Author: wallinrex <wallinrex@gmail.com>
Date:   Thu May 1 00:28:34 2025 -0500

    Made encode write the correct eof code
    
    But it's still not working correctly, I'll come back tomorrow

commit d0f665623e04aeaa1aa814e03b48c0c452ef1bc8
Author: wallinrex <wallinrex@gmail.com>
Date:   Wed Apr 30 23:50:26 2025 -0500

    Made decode not an infinite loop

commit 2e040555f3a1a212d0ecfa8234eee21780b9936f
Author: wallinrex <wallinrex@gmail.com>
Date:   Wed Apr 30 23:09:51 2025 -0500

    Fixed some small bugs so it at least starts to run

commit 72cf1ba05f48e4dc62a5c835c4de6e96c84762fc
Author: wallinrex <wallinrex@gmail.com>
Date:   Wed Apr 30 22:54:49 2025 -0500

    Implemented the rest of Grin

commit 0e8e9f86ef166a97e3729e2d244c66193097d90c
Author: wallinrex <wallinrex@gmail.com>
Date:   Tue Apr 29 21:53:07 2025 -0500

    Implemented decode driver

commit 090fd044dc795e5928e3f05f0eed8c30465795c0
Author: wallinrex <wallinrex@gmail.com>
Date:   Tue Apr 29 21:45:38 2025 -0500

    Implemented encode

commit 5895e47d6f20e7307c1d0a59e6805f7d432a05d2
Author: wallinrex <wallinrex@gmail.com>
Date:   Mon Apr 28 23:49:10 2025 -0500

    Implemented decode

commit be3faef7bd1507511f620f06ca6c26fc511021ac
Author: wallinrex <wallinrex@gmail.com>
Date:   Mon Apr 28 23:32:53 2025 -0500

    Implemented serialize

commit 4f5dac5f9f202c2b3ef1e28869fb8cfa2c607dd3
Author: wallinrex <wallinrex@gmail.com>
Date:   Fri Apr 25 23:34:07 2025 -0500

    Implemented the second HuffmanTree constructor

    There has got to be a more elegant way to do this

commit 2df5b66b7708f30dfad74d9772488d06172ee84d
Author: wallinrex <wallinrex@gmail.com>
Date:   Wed Apr 23 23:27:04 2025 -0500

    Implemented the first HuffmanTree constructor

commit 760697f8c6263176c45927308111c30ebaa4f913 (upstream/main, upstream/HEAD)
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Sat Apr 19 00:15:43 2025 -0500

    project files

commit 6ce2aa41fa0186a2c269cc6ce71acf9345984c73
Author: Peter-Michael Osera <osera@cs.grinnell.edu>
Date:   Sat Apr 19 00:02:47 2025 -0500

    initial commit
(END)
