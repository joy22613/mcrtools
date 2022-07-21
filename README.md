# mcrtools
Tools to parse .mcr and .mca files (by the Minecraft wiki documentation on [region file format](https://minecraft.fandom.com/wiki/Region_file_format) and [anvil file format](https://minecraft.fandom.com/wiki/Anvil_file_format)).

Currently in development. (The 4 source files are here because they are helpful.)

- divisioner.cpp divides files into fixed and equal sized (multiple of 1KB) sections.
- accumulater.cpp does the inverse.
- ConventionalDeflater.java deflates a file and puts the deflated contents in another file.
- ConventionalInflater.java inflates a file and puts the inflated contents in another file.

Usage:
divisioner filename numfiles numKB

accumulater filename numfiles numKB

java ConventionalDeflater.java filenamesrc filenamedest

java ConventionalInflater.java filenamesrc filenamedest

PS.This is my first repo

Also see [cNBT](https://github.com/chmod222/cNBT)
