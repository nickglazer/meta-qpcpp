AUTHOR = "Nicholas Glazer (nglazerdev@gmail.com)"

SUMMARY = "qpcpp"
DESCRIPTION = "Build Quantum Leaps QP/C++ as static library."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/QuantumLeaps/qpcpp.git;tag=v${PV} \
           file://qpcppConfig.cmake \
           file://Makefile \
           file://qpcppMakefile"

S = "${WORKDIR}"

EXTRA_OEMAKE = "'CPP=${CXX}' 'CC=${CC}'"

INSANE_SKIP_${PN} = "staticdev" 

do_install() {
    install --directory ${D}${libdir}/qpcpp
    install --directory ${D}${libdir}/qpcpp/rel
    install --directory ${D}${libdir}/qpcpp/spy
    install --directory ${D}${libdir}/qpcpp/dbg
    install --mode=0755 ${WORKDIR}/rel/qpcpp.a ${D}${libdir}/qpcpp/rel
    install --mode=0755 ${WORKDIR}/spy/qpcpp.a ${D}${libdir}/qpcpp/spy
    install --mode=0755 ${WORKDIR}/dbg/qpcpp.a ${D}${libdir}/qpcpp/dbg

    install --directory ${D}${datadir}/qpcpp
    install --mode=0755 ${WORKDIR}/qpcppConfig.cmake ${D}${datadir}/qpcpp

    install --directory ${D}${includedir}/qpcpp
    install --directory ${D}${includedir}/qpcpp/include
    install --directory ${D}${includedir}/qpcpp/ports/posix
    install --directory ${D}${includedir}/qpcpp/src
    install --mode=0755 ${S}/git/include/*.h ${D}${includedir}/qpcpp/include
    install --mode=0755 ${S}/git/ports/posix/*.h ${D}${includedir}/qpcpp/ports/posix
    install --mode=0755 ${S}/git/src/*.h ${D}${includedir}/qpcpp/src
}
