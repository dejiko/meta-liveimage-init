SUMMARY = "initramfs-framework module for live boot with squashfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
RDEPENDS_${PN} = "udev-extraconf"

inherit allarch

FILESEXTRAPATHS_prepend := "${THISDIR}/initramfs-framework:"
SRC_URI = "file://sqsscan \
           "

S = "${WORKDIR}"

do_install() {
    install -d ${D}/init.d
    install -m 0755 ${WORKDIR}/sqsscan ${D}/init.d/50-sqsscan
}

FILES_${PN} = "/init.d/50-sqsscan"
