/**
 *  Amcrest Camera (Connect)
 *
 *  Copyright 2016 David Guindon (Belgarion on SmartThings, programmer_dave@yahoo.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *
 *  You are free to use this code, provided the following conditions are met:
 *   - This software is free for Private Use.  You may use and modify the software without distributing it.
 *   - This software and any derivatives of it may not be used for commercial purposes.
 *   - The images and/or files that originate from "http://smartthings.belgarion.s3.amazonaws.com/" are for use within
 *     THIS code only and any reference to these resources beyond this use is expressly prohibited.
 *
 *  Citations:
 *   - pstuart: For his guidance and efforts on "Live Code Fridays"!
 *
 *  Release History:
 *    2016-04-23: v1.0.0 = Initial release
 *
 * NOTE: MJPEG does NOT transmit audio, RTSP does.
 *
 */
definition(
    name: "Amcrest Camera (Connect)",
    namespace: "belgarion",
    author: "David Guindon",
    description: "This SmartApp installs the Amcrest Video Camera (Connect) app so that you can add multiple Child Amcrest cameras.",
    category: "Safety & Security",
    iconUrl: "http://smartthings.belgarion.s3.amazonaws.com/images/IPM-721S.png",
    iconX2Url: "http://smartthings.belgarion.s3.amazonaws.com/images/IPM-721S@2x.png",
    iconX3Url: "http://smartthings.belgarion.s3.amazonaws.com/images/IPM-721S@2x.png")


preferences {
    page(name: "mainPage", title: "Amcrest Camera (Connect) v${appVersion()}", install: true, uninstall: true) {
        if (state?.installed) {
            section("Add a new Camera") {
                app "Amcrest Camera Child", "belgarion", "Amcrest Camera Child", title: "New Camera", page: "mainPage", multiple: true, install: true
            }
        }
        else {
            section("Initial Install") {
                paragraph "This SmartApp installs the Amcrest Camera (Connect) App so you can add multiple child video cameras. Click install / done then go to smartapps in the flyout menu and add new cameras or edit existing cameras."
            }
        }
    }
}

def appVersion() {
        return "1.0.0"
}

def installed() {
        log.debug "Installed with settings: ${settings}"

        initialize()
}

def updated() {
        log.debug "Updated with settings: ${settings}"

        unsubscribe()
        initialize()
}

def initialize() {
        // TODO: subscribe to attributes, devices, locations, etc.
}

// TODO: implement event handlers
