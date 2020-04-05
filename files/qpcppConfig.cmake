get_filename_component(CMAKE_CURRENT_LIST_DIR "${CMAKE_CURRENT_LIST_FILE}" PATH)

# Extract the directory where *this* file has been installed (determined at cmake run-time)
get_filename_component(QPCPP_CONFIG_PATH "${CMAKE_CURRENT_LIST_FILE}" PATH CACHE)

set(QPCPP_INSTALL_PATH "${QPCPP_CONFIG_PATH}/../..")

get_filename_component(QPCPP_INSTALL_PATH "${QPCPP_INSTALL_PATH}" REALPATH)

# Provide the include directories to the caller
set(QPCPP_INCLUDE_DIRS "${QPCPP_INSTALL_PATH}/include/qpcpp/include;${QPCPP_INSTALL_PATH}/include/qpcpp/src;${QPCPP_INSTALL_PATH}/include/qpcpp/ports/posix")
include_directories(${QPCPP_INCLUDE_DIRS})

set(QPCPP_SPY_LIB "${QPCPP_INSTALL_PATH}/lib/qpcpp/spy/qpcpp.a")
set(QPCPP_REL_LIB "${QPCPP_INSTALL_PATH}/lib/qpcpp/rel/qpcpp.a")
