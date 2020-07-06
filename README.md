# Bukkit Gui API
Makes it easy to create responsive GUIs

### Components
****
**Button** The default button component allows for simple interaction with menus. This button can have events attached to it to allow using input.

**ArrayButton** This button stores a list of buttons. It allows for pages of information to be created. You can define the starting slot and the ending slot
for the array it it will take care of filling it in with buttons.

**PageButton** This button allows you to create buttons that will automatically disappear at the start and end of a menu page.

**SwitcherButton** This button allows you to create a toggle which when click will switch between different options.


### Static Buttons
****
You can change a button to be static by using `button.setStatic(boolean)` if set to true will make a button appear on all pages of a menu. This is incompatable with the PageButton and the ArrayButton components.
