#!/usr/bin/env bash
set -e

# Benötigt: yq (https://github.com/mikefarah/yq)

YML="data/projects.yml"
README="README.md"
START_MARKER="<!-- LIBRARIES START -->"
END_MARKER="<!-- LIBRARIES END -->"

# Generiere Markdown aus projects.yml
output=""
group_count=$(yq '.projects | length' "$YML")
for ((g=0; g<group_count; g++)); do
  group=$(yq -r ".projects[$g].group" "$YML")
  items_count=$(yq ".projects[$g].items | length" "$YML")
  output+=$'\n<details'$( [[ "$group" == "KMP Libraries" || "$group" == "KMP Compose Libraries" ]] && echo ' open' )$'>\n\n'
  output+="<summary>$group ($items_count)</summary><br>\n\n"
  output+="| Libary | Description |\n| - | - |\n"
  for ((i=0; i<items_count; i++)); do
    name=$(yq -r ".projects[$g].items[$i].name" "$YML")
    desc=$(yq -r ".projects[$g].items[$i].description" "$YML")
    # Link generieren (GitHub-Repo-Name = Name, ggf. mit / am Ende)
    repo_url="https://github.com/MFlisar/$name"
    # Für ComposeDebugDrawerg ein / am Ende
    if [[ "$name" == "Lumberjack" || "$name" == "ComposeChangelog" || "$name" == "ComposeDebugDrawerg" ]]; then
      repo_url+="/"
    fi
    output+="| [$name]($repo_url) | $desc |\n"
  done
  output+=$'\n'</details>\n\n'
done

# Bereich im README ersetzen
awk -v start="$START_MARKER" -v end="$END_MARKER" -v content="$output" '
  BEGIN {inblock=0}
  {if ($0 ~ start) {print; print content; inblock=1; next} else if ($0 ~ end) {inblock=0}}
  !inblock {print}
' "$README" > "$README.tmp" && mv "$README.tmp" "$README"

