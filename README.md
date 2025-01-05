# Case Study: Home Automation

## Problem Statement

The goal of this project is to design and implement a **Home Automation System** that enables remote management and control of various devices and gadgets within a house. The system is designed to support multiple rooms, each containing different devices, with the ability to track their status, operational time, and allow users to remotely control these devices.

### Key Requirements

1. **Multiple Rooms in the House:**
    - The house can have multiple rooms, including but not limited to:
        - Kitchen
        - Living Area
        - Dining Area
        - Bedroom
        - Washroom
        - Corridors

2. **Devices in Each Room:**
    - Each room may contain various devices, such as:
        - **Electronic Devices** (e.g., televisions, lights, air conditioners)
        - **Lights**
        - **Air Conditioners**
        - **Televisions**
        - **Showers**

3. **Add Devices to Rooms:**
    - The system should allow users to **add devices** to any room.

4. **Remote Control of Devices:**
    - Users should be able to **remotely turn devices on and off** via the application.

5. **Status Monitoring:**
    - The system should provide the functionality to check the **status** of each device in each room, including whether the device is turned on or off.

6. **Track Device Usage Time:**
    - The system should keep track of the **total time** a device has been in its current state (on or off).

7. **Scalability for Future Devices:**
    - The system should be able to accommodate new device types as they are added in the future, without requiring major changes to the core structure.

---

## Features Implemented

- **Room Management:**
    - Supports multiple room types such as Kitchen, Living Area, Bedroom, etc.
    - Allows users to add, remove, and list rooms in the system.

- **Device Management:**
    - Devices such as TVs, Air Conditioners, and Lights can be added to rooms.
    - The system tracks the status (on/off) of devices and can toggle the state remotely.

- **Time Tracking:**
    - The application tracks how long each device has been in its current state (on/off) and provides the time elapsed.

- **Scalable System:**
    - The system is built to be easily extended with new device types, allowing future growth and adaptability.

---

## Technologies Used

- **Java:** Core language for building the system.
- **Object-Oriented Programming:** Used for creating classes like `Room`, `Device`, and `TV`.
- **LocalTime and Duration (Java Time API):** For tracking device operational time.

---

## Conclusion

This Home Automation System offers a simple yet scalable solution for managing and controlling devices within a home. It allows users to remotely manage devices, monitor their usage time, and easily add new devices as needed, making it a flexible and future-proof system for modern homes.
