DESCRIPTION = "Recipe to build the 'nano' editor"

PN = "nano"
PV = "5.0"

SRC_URI = "http://www.nano-editor.org/dist/v5/nano-5.0.tar.gz"
SRC_URI[sha256sum] = "e857e8037e96f765804ec62b4b8676bbad1a3d8f7425d31afc0b5e4348f2d155"

python do_fetch() {

    src_uri = (d.getVar('SRC_URI') or "").split()
    if len(src_uri) == 0:
        return

    try:
        fetcher = bb.fetch2.Fetch(src_uri, d)
        fetcher.download()
    except bb.fetch2.BBFetchException as e:
        bb.fatal(str(e))
}
addtask fetch before do_build

python do_unpack() {
    src_uri = (d.getVar('SRC_URI') or "").split()
    if len(src_uri) == 0:
        return

    try:
        fetcher = bb.fetch2.Fetch(src_uri, d)
        fetcher.unpack(d.getVar('WORKDIR'))
    except bb.fetch2.BBFetchException as e:
        bb.fatal(str(e))
}
addtask unpack before do_build after do_fetch

python do_configure() {
   os.system("cd ${WORKDIR}/${P} && ./configure")
}
addtask configure before do_build after do_unpack

python do_compile() {
   os.system("cd ${WORKDIR}/${P} && make")
}
addtask compile before do_build after do_configure
