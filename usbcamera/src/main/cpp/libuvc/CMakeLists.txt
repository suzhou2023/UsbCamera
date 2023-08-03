cmake_minimum_required(VERSION 3.22.1)

set(PROJECT_NAME bbt_uvc)
project(${PROJECT_NAME} VERSION 1.0)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}../build/${ANDROID_ABI}")
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}../build/${ANDROID_ABI}")


include_directories("${CMAKE_CURRENT_SOURCE_DIR}/include")


add_library(
        ${PROJECT_NAME}
        SHARED
        src/ctrl.c
        src/device.c
        src/diag.c
        src/frame.c
        src/frame-mjpeg.c
        src/init.c
        src/stream.c
)

link_directories("${CMAKE_CURRENT_BINARY_DIR}/../build/${ANDROID_ABI}")

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)


target_link_libraries( # Specifies the target library.
        ${PROJECT_NAME}

        bbt_usb
        jpeg
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})