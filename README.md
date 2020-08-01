# meta-base

![CI](https://github.com/codusnocturnus/meta-base/workflows/CI/badge.svg?branch=master)

A base layer for the BitBake build tool, providing just enough structure to build recipes, if those recipes are
self-contained, or additional scaffolding is provided by another layer.

NOTES:

+ BitBake (download separately, see link below) _MUST_ be on the PATH and PYTHONPATH to run successfully.
  + export PATH=/path/to/bitbake/bin:$PATH
  + export PYTHONPATH=/path/to/bitbake/lib:$PYTHONPATH
+ The build directory must contain the following file:
        \# .../conf/bblayers.conf
        BBLAYERS ?= "/path/to/meta-base"
+ Various parts of this layer have been "borrowed" from:
  + [pturley0](https://github.com/pturley0/bitbake-hello-world)
  + [BitBake](http://git.openembedded.org/bitbake)
  + [Poky](http://git.yoctoproject.org/cgit/cgit.cgi/poky/)
