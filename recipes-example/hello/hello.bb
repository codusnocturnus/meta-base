DESCRIPTION = "Example recipe"
PN = "hello"
PV = "1"

python do_build() {
    bb.plain("Hello, World!");
}
