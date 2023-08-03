cmake_minimum_required(VERSION 3.22.1)

set(PROJECT_NAME bbt_usb)
project(${PROJECT_NAME} VERSION 1.0)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/../build/${ANDROID_ABI}")
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/../build/${ANDROID_ABI}")


add_definitions(-DANDROID_NDK -DLOG_NDEBUG -DACCESS_RAW_DESCRIPTORS)
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -O3 -fstrict-aliasing -fprefetch-loop-arrays")

add_library(
        ${PROJECT_NAME}
        SHARED
        libusb/core.c
        libusb/descriptor.c
        libusb/hotplug.c
        libusb/io.c
        libusb/sync.c
        libusb/strerror.c
        libusb/os/android_usbfs.c
        libusb/os/poll_posix.c
        libusb/os/threads_posix.c
        libusb/os/android_netlink.c
)

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)


target_link_libraries( # Specifies the target library.
        ${PROJECT_NAME}


        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})