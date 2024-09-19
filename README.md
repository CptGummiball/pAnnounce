# pAnnounce
![Spigot](https://img.shields.io/badge/Spigot-1.20--1.21.1-yellow.svg)
![Paper](https://img.shields.io/badge/PaperMC-1.20--1.21.1-blue.svg)
![Version](https://img.shields.io/badge/Version-1.0.1-gray.svg)
![MIT License](https://img.shields.io/badge/License-MIT-green.svg)


pAnnounce is a Spigot plugin that announces specific players when they join the server. The announcement can be displayed in different forms: Actionbar, Chat, or Title. This allows server administrators to create unique notifications for certain players when they join.

## Features

- Announce players when they join the server using:
    - Actionbar messages
    - Chat messages
    - Title (with optional subtitle)
- Customizable messages, text colors, and sounds
- Configure specific players and how they are announced in `config.yml`

## Requirements

- **Spigot Version**: 1.20.4 or higher
- **Java Version**: Java 17 or higher

## Installation

1. Download the latest release of `pAnnounce.jar` from the [releases page](https://github.com/CptGummiball/pAnnounce/releases).
2. Place the `pAnnounce.jar` file into your server's `plugins/` folder.
3. Start or reload your server. The plugin will generate a default `config.yml` file in the `plugins/pAnnounce/` directory.

## Configuration

You can configure the plugin by editing the `config.yml` file. Each player who should be announced on the server can be added as a separate section. Here is an example configuration:

```yaml
TestPlayer1:
  Type: Actionbar
  Text: "This is a Text in the Actionbar"
  Textcolor: Not available in Actionbar
  Subtext: "Not available in Actionbar"
  Subtextcolor: Not available in Actionbar
  Sound: ENTITY_PLAYER_LEVELUP

TestPlayer2:
  Type: Chat
  Text: "This is a Text in the Chat"
  Textcolor: BLUE
  Subtext: "Not available in Chat"
  Subtextcolor: Not available in Chat
  Sound: BLOCK_NOTE_BLOCK_PLING

TestPlayer3:
  Type: Title
  Text: "This is a Text in the Title"
  Textcolor: RED
  Subtext: "This is a Subtext in Title"
  Subtextcolor: YELLOW
  Sound: ENTITY_ENDER_DRAGON_GROWL
```
### Configuration Options
- **Type:** Defines how the announcement will be displayed. Possible values:
``Actionbar``
``Chat``
``Title``
- **Text:** The main message to be displayed.
- **Textcolor:** The color of the main message (only applicable to Chat and Title).
- **Subtext:** An optional subtitle (only applicable to Title).
- **Subtextcolor:** The color of the subtitle (only applicable to Title).
- **Sound:** A valid Minecraft sound that will be played when the player joins.


**Supported Colors:**
You can use any valid Minecraft chat color for Textcolor and Subtextcolor.

**Supported Sounds:**
For a list of valid Minecraft sounds, you can refer to the official Minecraft Sound List.

## Usage
Once the plugin is installed and the configuration is set up, the plugin will automatically announce any players listed in the config.yml when they join the server. Depending on their configuration, the announcement will appear in the Actionbar, Chat, or as a Title for all players currently online.

## Development
If you want to contribute or modify the plugin, you can clone the repository:
```bash
git clone https://github.com/CptGummiball/pAnnounce.git
```
### Building the Plugin
1. Make sure you have Maven installed.

2. Navigate to the project directory and run:
```bash
mvn clean package
```
3. The compiled pAnnounce.jar file will be available in the target/ directory.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact
For any questions, suggestions, or issues, feel free to open an issue on the [GitHub Issues](https://github.com/CptGummiball/pAnnounce/issues) page.

