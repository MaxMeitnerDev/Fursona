![icon](https://i.imgur.com/MqSLlZK.png)

# **ᐅ Description**
This furry plugin for furries adds the ability to choose fursona. In addition to the fursonas already present in the plugin, you can add your own fursonas. The plugin supports SQLite, MySQL and HEX colors.

# **ᐅ Placeholders**
**%fursona_name%** - Show the fursona of the player.

# **ᐅ Commands and Permissions**
+ **/fursona help** - Displays a list of commands and descriptions.
+ **/fursona list** - Displays a list of fursonas (*fursona.list*).
+ **/fursona set *<fursona>*** - Set fursona (*fursona.set*).
+ **/fursona reload** - Reload the plugin (*fursona.reload*).

# **ᐅ Other**
+ ### **Support**
  + Discord server: https://discord.gg/QVU7X9852n
+ ### **Requirements**
  + [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/).
  + Server version 1.8+.

# **ᐅ Config**
```yml
MySQL:
  enabled: false
  host: "127.0.0.1"
  port: 3306
  database: "fursona"
  user: "root"
  password: "root"
#If enabled: false, the plugin will use SQLite.

fursona:
  notSelected: ""
  fox: "Fox"
  wolf: "Wolf"
  cat: "Cat"
  dog: "Dog"
  dragon: "Dragon"
  angelDragon: "Angel Dragon"
  rabbit: "Rabbit"
  hyena: "Hyena"
  deer: "Deer"
  sergal: "Sergal"
  protogen: "Protogen"
  primagen: "Primagen"
  hybrid: "Hybrid"
# If you want to add more fursonas, then just add them. Example:
#  horse: "Horse"
# The name of existing fursona can be changed. This can help in shortening the command. Example:
#  angd: "Angel Dragon"

messages:
  setFursona: "&7[&a&l✉&7] &fSet fursona: &a&l{fursona}&f."
  listFursonas: "&7[&a&l✉&7] &fList of fursonas: &a&l{list}&f."
  noPermReload: "&7[&c&l✖&7] &fYou don't have permission. &7(fursona.reload)"
  noPermSetFursona: "&7[&c&l✖&7] &fYou don't have permission. &7(fursona.set)"
  noPermListFursonas: "&7[&c&l✖&7] &fYou don't have permission. &7(fursona.list)"
  reload: "&7[&a&l♲&7] &fThe plugin has been reloaded."
  fursonaNotFound: "&7[&c&l✖&7] &fFursona not found. The list of fursonas can be viewed here: /fursona list"
  help: |
    &7[&e&l?&7] &f&lPlugin Help:
    &f/fursona help - Displays a list of commands and descriptions.
    &f/fursona list - Displays a list of fursonas.
    &f/fursona set <fursona> - Set fursona.
    &f/fursona reload - Reload the plugin.
# Use #______ for HEX colors.
```
